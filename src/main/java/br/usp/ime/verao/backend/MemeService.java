package br.usp.ime.verao.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemeService {
    private final MemeRepository memeRepository;

    @Autowired
    public MemeService(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }

    public Meme insert(Meme meme) {
        return memeRepository.save(meme);
    }

    public Optional<Meme> find(Long id) {
        return memeRepository.findById(id);
    }

    public List<Meme> findAll() {
        return memeRepository.findAll();
    }

    public Meme update(Long id, Meme newMeme) {
        if(find(id).isEmpty())
            return null;

        Meme meme = find(id).get();

        meme.setMidia(newMeme.getMidia());
        meme.setKeywords(newMeme.getKeywords());
        meme.setName(newMeme.getName());

        return memeRepository.save(meme);
    }

    public void delete(Long id) {
        memeRepository.deleteById(id);
    }
}
