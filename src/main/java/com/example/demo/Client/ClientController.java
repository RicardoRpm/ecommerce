package com.example.demo.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/registrar")
    public ModelAndView registar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/register");
        mv.addObject("client", new Client());
        return mv;
    }

    @PostMapping("/registrar_client")
    public String registar_client(Client client){
        clientService.createClient(client);
        return "admin/register";
    }

    @RequestMapping("/cliente/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/Client/index");
        mv.addObject("clients", clientService.getClients());
        return mv;
    }
}
