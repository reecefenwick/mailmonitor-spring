package au.com.suncorp.mailmonitor.repository;

import au.com.suncorp.mailmonitor.domain.Mailbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailboxRepository extends JpaRepository<Mailbox, String> {
    Mailbox findMailboxById(String ID);
}
