package ioc.looselyCoupled;

public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void OutputHelper(){
        //outputGenerator = new CsvOutputGenerator();
        outputGenerator.generateOutput();
    }

    public void generateOutput(){
        outputGenerator.generateOutput();
    }

    public IOutputGenerator getOutputGenerator() {
        return outputGenerator;
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
}
