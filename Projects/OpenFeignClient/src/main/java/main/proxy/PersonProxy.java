package main.proxy;

import main.models.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="OpenFeign", url="${name.service.uri}")
public interface PersonProxy {

    @PostMapping("/person")
    public Person getPerson(
            @RequestHeader String requestId,
            @RequestBody Person person
    );

}
