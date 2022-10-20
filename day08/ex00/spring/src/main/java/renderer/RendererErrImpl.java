package renderer;

import preproc.PreProcessor;

public class RendererErrImpl implements Renderer{
	private PreProcessor preProcessor;

	public RendererErrImpl(PreProcessor preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Override
	public void printText(String text) {
		System.err.println(preProcessor.preProcess(text));
	}
}
