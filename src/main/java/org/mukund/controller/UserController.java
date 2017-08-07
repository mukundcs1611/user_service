package org.mukund.controller;

import org.mukund.entity.User;
import org.mukund.service.UserService;
import org.mukund.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping(value="user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method= RequestMethod.GET,value="")
    public List<User> findAll(){//get

        return userService.findAll();
    }

    @RequestMapping(method=RequestMethod.GET,value="{id}")
    public User findOne(@PathVariable("id") String userId){//get
    return userService.findOne(userId);
    }

    @RequestMapping(method=RequestMethod.POST,value="authenticate",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody User authenticate(@RequestBody Map<String,String> params ){
        String param =params.get("param");
        String password=params.get("password");
        return userService.authenticate(param,password);
    }

    @RequestMapping(method=RequestMethod.POST,
                    consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User create(@RequestBody User user){//post
    return userService.create(user);
    }

    @RequestMapping(method=RequestMethod.PUT,value="{id}",
                    consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User update(@PathVariable("id")String id, @RequestBody User user){//put
    return userService.update(id,user);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);

    }
}