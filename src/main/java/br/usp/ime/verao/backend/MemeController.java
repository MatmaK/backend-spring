package br.usp.ime.verao.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/memes")
public class MemeController {
    private final MemeService memeService;

    @Autowired
    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping
    List<Meme> findAll() {
        return memeService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Meme> find(@PathVariable("id") Long id) {
        return memeService.find(id);
    }

    @PostMapping
    Meme newMeme(@RequestBody Meme newMeme) {
        return memeService.insert(newMeme);
    }

    @PutMapping("/{id}")
    Meme updateMeme (@PathVariable("id") Long id, @RequestBody Meme newMeme) {
        return memeService.update(id, newMeme);
    }

    @DeleteMapping("/{id}")
    void deleteMeme (@PathVariable("id") Long id) {
        memeService.delete(id);
    }
}
