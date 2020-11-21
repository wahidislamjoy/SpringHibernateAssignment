package com.springdemo.controller;

import com.springdemo.entity.Country;
import com.springdemo.entity.Player;
import com.springdemo.entity.Team;
import com.springdemo.service.PlayerService;
import com.springdemo.service.TeamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    TeamService teamService;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    PlayerService playerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


@GetMapping("/list")
   public String showPlayers(Model model)
{
    List<Player> players = playerService.getPlayers();

    model.addAttribute("players",players);

    return "player-list";
}

    @RequestMapping("/showFormForAdd")
    public   String showFormForAdd(Model model)
    {
        Player player = new Player();
        model.addAttribute("player",player);
        return "player-form";

    }



    @PostMapping("savePlayer")
    public  String savePlayer(@Valid @ModelAttribute Player player , BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "player-form";
        }
        else {
            playerService.SavePlayer(player);

            return "redirect:/player/list";
        }

    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("playerId") int id, Model model)
    {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player",player);
        return "player-update-form";
    }


    @GetMapping("/delete")
    public String deletePlayer(@RequestParam("playerId") int id )
    {
       playerService.DeletePlayer(id);
        return "redirect:/player/list";
    }

    @PostMapping("/updatePlayer")

    public String updatePlayer(@Valid@ModelAttribute Player player , BindingResult bindingResult)
    {

        if (bindingResult.hasErrors())
        {
            return "player-update-form";
        }
        else {
            playerService.updatePlayer(player);

            return "redirect:/player/list";
        }

    }

}
