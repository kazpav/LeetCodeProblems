public class TestInput<TInput, TOutput> {
    public TInput[] Input;
    public TOutput Expected;

    public TestInput(TInput[] input, TOutput expected) {
        Input = input;
        Expected = expected;
    }
}
