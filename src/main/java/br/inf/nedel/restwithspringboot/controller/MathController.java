package br.inf.nedel.restwithspringboot.controller;

import br.inf.nedel.restwithspringboot.exception.ResourceNotFoundException;
import br.inf.nedel.restwithspringboot.math.SimpleMath;
import br.inf.nedel.restwithspringboot.request.converters.NumberConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MathController {
//    private SimpleMath math = new SimpleMath();
    @Autowired
    private SimpleMath math;




    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }

        return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));

    }


    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne) ,NumberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return math.mean(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String numberOne) throws Exception {
        if(!NumberConverter.isNumeric(numberOne)){
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return  math.squareRoot (NumberConverter.convertToDouble(numberOne) );
    }


}