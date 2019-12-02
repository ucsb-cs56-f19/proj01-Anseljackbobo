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


import earthquakes.searches.LocSearch;
import java.util.List;

@Controller
public class LocationsController {

    @GetMapping("/locations/search")
    public String getLocationsSearch(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch LocSearch) {
        return "locations/search";
    }

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;

   

    @GetMapping("/locations/results")
    public String getLocationsResults(Model model, OAuth2AuthenticationToken oAuth2AuthenticationToken,
            LocSearch locSearch) {
        model.addAttribute("locSearch", locSearch);
        // TODO: Actually do the search here and add results to the model
        return "locations/results";
    }
    
    
}
