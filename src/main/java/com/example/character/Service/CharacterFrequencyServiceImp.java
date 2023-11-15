package Service;

import Model.CharacterFrequency;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterFrequencyServiceImp implements CharacterFrequencyService {
    @Override
    public List<CharacterFrequency> calculateFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<CharacterFrequency> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            CharacterFrequency cf = new CharacterFrequency();
            cf.setCharacter(entry.getKey());
            cf.setFrequency(entry.getValue());
            result.add(cf);
        }

        result.sort(Comparator.comparingInt(CharacterFrequency::getFrequency).reversed());

        return result;
    }
}
