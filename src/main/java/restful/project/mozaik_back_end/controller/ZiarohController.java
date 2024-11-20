package restful.project.mozaik_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.project.mozaik_back_end.entity.Ziaroh;
import restful.project.mozaik_back_end.service.ZiarohService;

import java.util.List;

@RestController
@RequestMapping("/api/ziaroh")
public class ZiarohController {
    @Autowired
    private ZiarohService ziarohService;

    @GetMapping
    public List<Ziaroh> getAllZiaroh() {
        return ziarohService.getAllZiaroh();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ziaroh> getZiarohById(@PathVariable Long id) {
        return ziarohService.getZiarohById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ziaroh createZiaroh(@RequestBody Ziaroh ziaroh) {
        return ziarohService.createZiaroh(ziaroh);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ziaroh> updateZiaroh(@PathVariable Long id, @RequestBody Ziaroh ziaroh) {
        return ResponseEntity.ok(ziarohService.updateZiaroh(id, ziaroh));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZiaroh(@PathVariable Long id) {
        ziarohService.deleteZiaroh(id);
        return ResponseEntity.noContent().build();
    }
}


