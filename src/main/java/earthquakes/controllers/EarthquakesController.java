package earthquakes.controllers;
import earthquakes.geojson.FeatureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import java.util.HashMap;

import com.nimbusds.oauth2.sdk.client.ClientReadRequest;

import earthquakes.services.EarthquakeQueryService;
import earthquakes.searches.EqSearch;

@Controller
public class EarthquakesController {

    @GetMapping("/earthquakes/search")
    public String getEarthquakesSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            EqSearch eqSearch) {
        return "earthquakes/search";
    }

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

   

    @GetMapping("/earthquakes/results")
    public String getEarthquakesResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            EqSearch eqSearch) {
        EarthquakeQueryService e =
            new EarthquakeQueryService();
        model.addAttribute("eqSearch", eqSearch);
        String json = e.getJSON(eqSearch.getDistance(), eqSearch.getMinmag());
        model.addAttribute("json", json);
        return "earthquakes/results";
        
    }
    
    
}