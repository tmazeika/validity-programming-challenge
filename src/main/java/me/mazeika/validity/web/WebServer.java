package me.mazeika.validity.web;

import freemarker.template.Configuration;
import freemarker.template.Template;
import me.mazeika.validity.csv.PersonEntry;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.get;

/**
 * Represents a web server that displays duplicates found in people entries.
 */
public class WebServer
{
    private final Configuration tmplConfig;
    private final List<List<String>> duplicates;

    /**
     * Constructs a new WebServer.
     *
     * @param duplicates the duplicate person entries
     */
    public WebServer(List<List<PersonEntry>> duplicates)
    {
        this.tmplConfig = new Configuration();

        // convert PersonEntry to its raw string form; also effectively makes
        // a copy
        this.duplicates = duplicates.stream()
                .map(dups -> dups.stream()
                        .map(PersonEntry::toString)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        this.tmplConfig.setClassForTemplateLoading(getClass(), "/");
    }

    /**
     * Starts the web server.
     */
    public void start()
    {
        get("/", (req, res) -> {
            final Template tmpl = this.tmplConfig.getTemplate("index.html");
            final StringWriter writer = new StringWriter();
            final Map<String, Object> model = new HashMap<>() {{
                put("duplicates", duplicates);
            }};

            try {
                tmpl.process(model, writer);
            } catch (IOException e) {
                e.printStackTrace();
                Spark.halt(500);
            }

            return writer;
        });
    }
}
