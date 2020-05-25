package com.chinakalight.algo.basic2;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 5/3/2020
 */
public class Laboratory {
    Microscope microscope;

    ResultC analyze(Sample sample){
        if(microscope.isInorganic(sample)){
            return ResultC.INORGANIC;
        }else{
            return analyzeOrganic(sample);
        }
    }

    private ResultC analyzeOrganic(Sample sample){
        if(!microscope.isHumanoid(sample)){
            return ResultC.ALIEN;
        }else{
            return ResultC.HUMANOID;
        }
    }
}

class Laboratory2 {
    Microscope microscope;

    ResultC analyze(Sample sample){
        if(microscope.isOrganic(sample)){
            return analyzeOrganic(sample);
        }else{
            return ResultC.INORGANIC;
        }
    }

    ResultC analyzeOrganic(Sample sample){
        if(microscope.isHumanoid(sample)){
            return ResultC.HUMANOID;
        }else{
            return ResultC.ALIEN;
        }
    }
}

class Microscope {

    public boolean isInorganic(Sample sample){
        return sample.getBASE_VALUE() == 2;
    }


    public boolean isHumanoid(Sample sample){
        return sample.getBASE_VALUE() != 2;
    }
    /**
     * Alternative Functionality Implementation
     * to isInorganic()
     * @param sample
     * @return
     */
    public boolean isOrganic(Sample sample){
        return true;
    }

}


class ResultC {
    public static final ResultC INORGANIC = new ResultC();
    public static ResultC ALIEN = new ResultC(ResultC.ALIEN_RESULT);
    public static ResultC HUMANOID =  new ResultC(ResultC.HUMANOID_RESULT);
    private static final String ALIEN_RESULT = "ALIEN_RESULT_SPECIE";
    private static final String HUMANOID_RESULT = "HUMANOID_RESULT_SPECIE";
    private static final String ORGANIC = "ORGANIC_SAMPLE";
    private String state;
    public ResultC(){ this.state = ORGANIC; }
    public ResultC(String state){ this.state = state; }
}

class Sample {
    private int BASE_VALUE = 2;

    public int getBASE_VALUE() {
        return BASE_VALUE;
    }

    public void setBASE_VALUE(int BASE_VALUE) {
        this.BASE_VALUE = BASE_VALUE;
    }
}
