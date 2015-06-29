package org.teasdale.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class SimpMessagingTemplateService {
    @Autowired SimpMessagingTemplate simpMessagingTemplate

    public SimpMessagingTemplate getTemplate() {
        return simpMessagingTemplate
    }
}
