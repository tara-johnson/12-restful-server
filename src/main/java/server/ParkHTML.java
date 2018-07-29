package server;

import com.google.gson.Gson;
import models.Park;
import models.ParkStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/parks")
public class ParkHTML {
    // list all parks page
    @GetMapping
    public String showAllParks(Model model) {
        Collection<Park> parks = ParkStorage.parks.values();
        List<Park> list = new ArrayList<>(parks);

        model.addAttribute("parks", parks);
        return "all_parks";
    }

    // create HTML form
    @GetMapping("/new")
    public String createParkForm() {
        return "create_park";
    }

    // update HTML form
    @GetMapping("/{id}/edit")
    public String editParkForm(
            @PathVariable("id") int id,
            Model model
    ) {
        Park park = ParkStorage.parks.get(id);

        model.addAttribute("id", park.id);
        model.addAttribute("name", park.name);
        model.addAttribute("location", park.location);
        model.addAttribute("area", park.area);

        return "edit_park";
    }
}