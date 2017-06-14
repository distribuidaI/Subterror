package ar.edu.undav.subterror.rest;

import ar.edu.undav.subterror.model.Line;
import ar.edu.undav.subterror.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leo on 6/14/17.
 */

@RestController
@RequestMapping(value = "/line")
public class LineController {
    private LineRepository lineRepository;

    @Autowired
    public LineController(LineRepository lineRepository){
        this.lineRepository = lineRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Line> getAll(){
        return lineRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<Line> addLine(@RequestBody Line line){
        lineRepository.save(line);

        return lineRepository.findAll();
    }
}
