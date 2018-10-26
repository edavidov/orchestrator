package pro.baas.api.externals.dbpedia.consumer;


import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;

import static java.net.URLEncoder.encode;

@Component
@Slf4j
public class RequestUrlBuilder {

    private static final String UTF_8 = "UTF-8";
    private static final String JSON = "json";
    private static final String COMPANY_NAME = "companyName";

    @Value("${dbpedia.api.url}")
    private String apiUrl;

    private VelocityEngine velocityEngine;

    private static final String QUERY_TEMPLATE = "dbpedia/queryTemplate.vm";

    public RequestUrlBuilder() {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    }

    public URI buildUrl(String companyName) throws UnsupportedEncodingException {

        return UriComponentsBuilder.fromHttpUrl(apiUrl)
                                   .queryParam("query", encode(loadTemplate(companyName), UTF_8))
                                   .queryParam("format", JSON)
                                   .encode()
                                   .build(true)
                                   .toUri();
    }

    private String loadTemplate(String companyName) {
        Template template = velocityEngine.getTemplate(QUERY_TEMPLATE, UTF_8);
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put(COMPANY_NAME, companyName);

        StringWriter swOut = new StringWriter();
        template.merge(velocityContext, swOut);
        return swOut.toString();
    }
}
