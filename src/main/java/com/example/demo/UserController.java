package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
     private UserDao userDao;


    @RequestMapping(value="/list")
    public @ResponseBody Iterable<User>  GetAll(){
        return userDao.findAll();
    }

    @RequestMapping(value="/add")
        public @ResponseBody String add(@RequestParam("name") String name){
        User user=new User();
        user.setName(name);
        userDao.save(user);
        return "Saved";
    }


    @RequestMapping(value = "delUser")
    public @ResponseBody String delUser(@RequestParam("id") Integer id){
       userDao.deleteById(id);
       return "Delete Done";
    }

    @RequestMapping(value="/update")
    public @ResponseBody String update(@RequestParam("id") Integer id,
                @RequestParam("name") String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        userDao.save(user);
        return "Updated";
    }
}
