package au.com.suncorp.mailmonitor.api;

import au.com.suncorp.mailmonitor.api.dto.MailboxDTO;
import au.com.suncorp.mailmonitor.domain.Mailbox;
import au.com.suncorp.mailmonitor.repository.MailboxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api/mailbox")
public final class MailboxController {

    private static final Logger log = LoggerFactory.getLogger(MailboxController.class);

    @Autowired
    private MailboxRepository mailboxRepository;


    @RequestMapping(method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Mailbox> getAllMailboxes() {
        return mailboxRepository.findAll();
    }

    @RequestMapping(method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewMailbox(@RequestBody @Valid MailboxDTO payload) {
        Mailbox mailbox = new Mailbox(
                payload.getDescription(),
                payload.getUsername(),
                payload.getPassword(),
                payload.getAlertRecipient(),
                payload.getActive()
        );

        mailboxRepository.save(mailbox);

        return new ResponseEntity<>(mailbox, HttpStatus.CREATED);
    }

    @RequestMapping(method = GET,
            value = "/{key}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mailbox> getMailbox(@PathVariable String id) {
        Mailbox mailbox = mailboxRepository.findMailboxById(id);

        if (mailbox == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mailbox, HttpStatus.OK);
    }

    @RequestMapping(method = DELETE, value = "/{key}")
    public ResponseEntity<?> deleteUpload(@PathVariable String id) {
        Mailbox upload = mailboxRepository.findMailboxById(id);

        if (upload == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        mailboxRepository.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
