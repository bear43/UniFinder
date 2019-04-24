package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import service.UserService;

@Component
public class LoginAttemptsLogger
{
    private final UserService userService;

    @Autowired
    public LoginAttemptsLogger(UserService userService)
    {
        this.userService = userService;
    }

    @EventListener
    public void auditEventHappened(AuditApplicationEvent auditApplicationEvent)
    {
        AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();
        if(auditEvent.getType().equals("AUTHENTICATION_SUCCESS"))
            userService.fillCurrentUser(auditEvent.getPrincipal());
        else if(auditEvent.getType().equals("AUTHORIZATION_FAILURE"))
            userService.setCurrentUser(null);
    }
}
