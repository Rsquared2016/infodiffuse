import java.io.File;
import java.io.IOException;
import java.util.Map;

import weka.classifiers.functions.SMO;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClassifier;

public class Classification {

	public static Dataset loadData(String file) throws IOException {
		Dataset data = FileHandler.loadDataset(new File(file), 7, ",");
		return data;
	}

	public static void performSVM(String file) throws IOException {
		Dataset dataset = loadData(file);
		SMO smo = new SMO();
		Classifier classifier = new WekaClassifier(smo);
		CrossValidation cv = new CrossValidation(classifier);
		/* Perform cross-validation */
		Map<Object, PerformanceMeasure> pm = cv.crossValidation(dataset);
		/* Output results */
		System.out.println(pm.get("-1").getAccuracy());
	}

	public static void main(String[] args) throws IOException {
		performSVM(args[0]);
	}

}
