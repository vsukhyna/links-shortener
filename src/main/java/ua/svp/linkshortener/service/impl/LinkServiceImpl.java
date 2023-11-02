package ua.svp.linkshortener.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ua.svp.linkshortener.model.ShortLinkModel;
import ua.svp.linkshortener.service.LinkService;

import java.util.Date;
import java.util.Objects;
import java.util.Queue;

@Service
public class LinkServiceImpl implements LinkService {

    private final RedisTemplate<String, ShortLinkModel> template;

    private final Queue<String> shortLinks;

    public LinkServiceImpl(RedisTemplate<String, ShortLinkModel> template,
                           Queue<String> shortLinks) {
        this.template = template;
        this.shortLinks = shortLinks;
    }

    @Override
    public String useShortLink(String shortLink) {

        ShortLinkModel model = get(shortLink);

        if (model != null) {
            return model.getUserLink();
        }

        return null;
    }

    @Override
    public String generateShortLink(String userLink) {
        return save(userLink);
    }

    private String save(String userLink) {

        ShortLinkModel model = new ShortLinkModel();
        model.setUserLink(userLink);
        model.setShortLink(shortLinks.element());
        model.setCreatedDate(new Date());

        template.opsForValue().set(model.getShortLink(), model);

        return shortLinks.remove();
    }

    public ShortLinkModel get(String shortLink) {
        return template.opsForValue().get(shortLink);
    }

    @Override
    public void clearAll() {
        template.delete(Objects.requireNonNull(template.keys("*")));
    }

}
