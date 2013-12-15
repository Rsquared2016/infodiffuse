import java.io.File;
import java.io.IOException;
import java.util.Map;

import weka.classifiers.trees.RandomForest;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.EvaluateDataset;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.tools.weka.WekaClassifier;

public class Classification {

	public static Dataset loadData(String file) throws IOException {
		Dataset data = FileHandler.loadDataset(new File(file), 7, ",");
		return data;
	}

	public static void performSVM(String file, String test) throws IOException {
		Dataset dataset = loadData(file);
		Dataset tesDataset = loadData(test);
		weka.classifiers.trees.RandomForest smo = new weka.classifiers.trees.RandomForest();
		Classifier classifier = new WekaClassifier(smo);
		classifier.buildClassifier(dataset);

		/* Perform cross-validation */
		Map<Object, PerformanceMeasure> pm = EvaluateDataset.testDataset(
				classifier, tesDataset);
		/* Output results */
		PerformanceMeasure measure = pm.get("1");
		PerformanceMeasure measure2 = pm.get("-1");
		System.out.println(measure.getAccuracy());
		System.out.println(measure.getTPRate());
		System.out.println(measure2.getTNRate());
		System.out.println(measure.getPrecision());
		System.out.println(measure2.getPrecision());
		System.out.println(measure.getFMeasure());
		System.out.println(measure2.getFMeasure());
	}

	public static void crossValidation(String file, String test)
			throws IOException {
		Dataset dataset = loadData(file);
		// Dataset tesDataset = loadData(test);
		Classifier smo = new net.sf.javaml.classification.tree.RandomForest(
				1000);

		CrossValidation cv = new CrossValidation(smo);
		/* Perform cross-validation on the data set */
		Map<Object, PerformanceMeasure> p = cv.crossValidation(dataset);

		/* Output results */
		PerformanceMeasure measure = p.get("1");
		PerformanceMeasure measure2 = p.get("-1");
		System.out.println(measure.getAccuracy());
		System.out.println(measure.getTPRate());
		System.out.println(measure2.getTNRate());
		System.out.println(measure.getPrecision());
		System.out.println(measure2.getPrecision());
		System.out.println(measure.getFMeasure());
		System.out.println(measure2.getFMeasure());
	}

	public static void performDecisionTree(String file, String test)
			throws IOException {
		Dataset dataset = loadData(file);
		Dataset tesDataset = loadData(test);
		Classifier knn = new KNearestNeighbors(5);
		CrossValidation cv = new CrossValidation(knn);
		Map<Object, PerformanceMeasure> pm = cv.crossValidation(dataset);

		/* Output results */
		PerformanceMeasure measure = pm.get("1");	
		PerformanceMeasure measure2 = pm.get("-1");
		System.out.println(measure.getAccuracy());
		System.out.println(measure.getTPRate());
		System.out.println(measure2.getTNRate());
		System.out.println(measure.getPrecision());
		System.out.println(measure2.getPrecision());
		System.out.println(measure.getFMeasure());
		System.out.println(measure2.getFMeasure());
	}

	public static void main(String[] args) throws IOException {
		// performSVM(args[0], args[1]);
		 //performDecisionTree(args[0], args[1]);
		crossValidation(args[0], args[1]);

	}

}
