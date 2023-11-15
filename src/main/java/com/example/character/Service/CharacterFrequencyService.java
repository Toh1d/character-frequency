package Service;

import Model.CharacterFrequency;

import java.util.List;

public interface CharacterFrequencyService {
    public List<CharacterFrequency> calculateFrequency(String input);
}
