package org.teasdale.services

import groovy.util.logging.Log
import org.apache.commons.lang3.Validate
import org.springframework.stereotype.Service
import org.teasdale.entities.Chatter
import org.teasdale.util.Constants

@Service
@Log
class ChatterService {
    def newChatter(String name, String chatId) {
        Validate.notNull(name, "name cannot be null")
        Validate.notNull(chatId, "id cannot be null")

        Chatter newChatter = new Chatter(
                name: name,
                chatId: chatId
        ).save(flush:true)

        return newChatter
    }

    def deleteChatter(String chatId) {
        Validate.notNull(chatId, "id cannot be null")

        Chatter chatter = Chatter.findByChatId(chatId)
        chatter.delete()
    }

    Collection<Chatter> getAllChatters() {
        return Chatter.findAll()
    }

    boolean serverOnline() {

        def allChatters = getAllChatters().collect{it.chatId}
        log.info "all chatters: ${allChatters}"

        Constants.SERVER_CHAT_ID in getAllChatters().collect{it.chatId}
    }

    boolean readyForChat() {
        serverOnline() && getAllChatters().size() == 1
    }
}
