package org.teasdale.controllers

import groovy.util.logging.Log
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.teasdale.util.Constants

import javax.servlet.http.HttpServletRequest

@Controller
@Log
class PortalController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {

        log.info "The remote address is ${request.remoteAddr}"

        if( ["127.0.0.1", "0:0:0:0:0:0:0:1"].contains(request.remoteAddr)) {
            return "server_landing"
        } else {
            model.addAttribute("chatId", UUID.randomUUID().toString())
            return "client_landing"
        }
    }

    @RequestMapping("/server")
    public String server(Model model) {
        model.addAttribute("name", Constants.SERVER_CHAT_NAME)
        model.addAttribute("chatId", Constants.SERVER_CHAT_ID)
        return "server"
    }

    @RequestMapping("/client")
    public String client(
            @RequestParam(value="name", required=false) name,
            @RequestParam(value="chatId", required=true) chatId,
            Model model
    ) {
        model.addAttribute("name", name)
        model.addAttribute("chatId", chatId)
        model.addAttribute("serverId", Constants.SERVER_CHAT_ID)
        return "client"
    }
}
