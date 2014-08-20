package pe.yhlee;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FirstMahout {

    public static void main(String[] args) throws IOException, TasteException {

//        DataModel dm = new FileDataModel(new File("classpath:intro.csv"));
        DataModel dm = new FileDataModel(new File("/Users/yonghee/Study/intelliJWS/mahout-exec/src/main/resources/pe/yhlee/intro.csv"));
        UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dm);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, userSimilarity, dm);

        Recommender recommender = new GenericUserBasedRecommender(dm, neighborhood, userSimilarity);
        List<RecommendedItem> recommenderList = recommender.recommend(1, 1);

        for (RecommendedItem recommendedItem : recommenderList) {
            System.out.println(recommendedItem);
        }

        System.out.println("Hello Mahout!!");
        // write your code here
        // what's wrong?
    }
}
