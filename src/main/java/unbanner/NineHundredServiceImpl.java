package unbanner;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NineHundredServiceImpl implements NineHundredService {

  @Autowired
  private NineHundredRepository nineHundredRepository;

  @Override
  public int getNext() {
    NineHundred last = nineHundredRepository.findTopByOrderByIdDesc();
    int lastNum = last.seq;
    NineHundred next = new NineHundred(lastNum + 1);
    nineHundredRepository.save(next);
    return next.seq;
  }
}
