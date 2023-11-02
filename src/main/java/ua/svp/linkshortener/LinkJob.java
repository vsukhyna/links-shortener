package ua.svp.linkshortener;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.svp.linkshortener.service.LinkService;

@Component
@EnableScheduling
public class LinkJob {

    private final LinkService service;

    public LinkJob(LinkService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 60000L)
    public void freeLink() {
        service.clearAll();
    }
}
