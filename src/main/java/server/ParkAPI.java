package server;

import com.google.gson.Gson;
import models.Park;
import models.ParkStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/parks")
public class ParkAPI {
    // create
    @PostMapping
    @ResponseBody
    public ModelAndView createPark(
        @RequestParam("name") String name,
        @RequestParam("location") String location,
        @RequestParam("area") int area
    ) {
        Park park = new Park(name, location, area);
        ParkStorage.parks.put(park.id, park);
        return new ModelAndView("redirect:/parks");
    }

    // read all
    @GetMapping
    @ResponseBody
    public List<Park> getAllParks() {
        Collection<Park> parks = ParkStorage.parks.values();
        return new ArrayList<>(parks);
    }

    // read one
    @GetMapping("/{id}")
    @ResponseBody
    public Park getOnePark(@PathVariable("id") int id) {
        Park result = ParkStorage.parks.get(id);
        return result;
    }

    // update
    @PutMapping("/{id}")
    @ResponseBody
    public Park updatePark(
        @PathVariable("id") int id,
        @RequestBody String body
    ) {
        Gson gson = new Gson();
        Park newPark = gson.fromJson(body, Park.class);

        Park park = ParkStorage.parks.get(id);
        park.name = newPark.name;
        park.location = newPark.location;
        park.area = newPark.area;
        return park;
    }

    // destroy
    @DeleteMapping("/{id}")
    @ResponseBody
    public Park deletePark(@PathVariable("id") int id) {
        Park park = ParkStorage.parks.get(id);
        ParkStorage.parks.remove(id);
        return park;
    }
}
