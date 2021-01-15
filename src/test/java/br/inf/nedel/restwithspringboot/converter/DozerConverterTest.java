package br.inf.nedel.restwithspringboot.converter;

import br.inf.nedel.restwithspringboot.converter.mocks.MockPerson;
import br.inf.nedel.restwithspringboot.data.vo.PersonVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DozerConverterTest {
    MockPerson inputObject;

    @Before
    public void setUp(){
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest(){
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L),output.getId());
        Assert.assertEquals("First Name Test0", output.getFirtsName());
        Assert.assertEquals("Last Name Test0",output.getLastName());
        Assert.assertEquals("Address Test0",output.getAddress());
        Assert.assertEquals("Male",output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest(){
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(),PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        Assert.assertEquals(Long.valueOf(0L),outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirtsName());
        Assert.assertEquals("Last Name Test0",outputZero.getLastName());
        Assert.assertEquals("Address Test0",outputZero.getAddress());
        Assert.assertEquals("Male",outputZero.getGender());

        PersonVO outputSeven = outputList.get(7);
        Assert.assertEquals(Long.valueOf(7L),outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirtsName());
        Assert.assertEquals("Last Name Test7",outputSeven.getLastName());
        Assert.assertEquals("Address Test7",outputSeven.getAddress());
        Assert.assertEquals("Female",outputSeven.getGender());

        PersonVO outputTwelve = outputList.get(12);
        Assert.assertEquals(Long.valueOf(12L),outputSeven.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirtsName());
        Assert.assertEquals("Last Name Test12",outputTwelve.getLastName());
        Assert.assertEquals("Address Test12",outputTwelve.getAddress());
        Assert.assertEquals("Female",outputTwelve.getGender());


    }
}
