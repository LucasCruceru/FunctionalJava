package ro.lucas.chapter4.asset;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static ro.lucas.chapter4.asset.Asset.AssetType.BOND;
import static ro.lucas.chapter4.asset.Asset.AssetType.STOCK;

public class AssetUtil {
    public static void main(String[] args) {
        final List<Asset> assets = Arrays.asList(
                new Asset(BOND, 1000),
                new Asset(BOND, 2000),
                new Asset(STOCK, 3000),
                new Asset(STOCK, 4000)
        );
        printAssetsValues(assets);

    }

    private static void printAssetsValues(List<Asset> assets) {
        System.out.println("Total of all assets: " + totalAssetsValue(assets, asset -> true));
        System.out.println("Total of all bond assets: " + totalAssetsValue(assets, asset ->
                asset.getType() == STOCK));
        System.out.println("Total of all stock assets: " + totalAssetsValue(assets, asset ->
                asset.getType() == BOND));
    }

    private static int totalAssetsValue(final List<Asset> assets,
                                       final Predicate<Asset> assetSelector){
        return assets.stream()
                .filter(assetSelector)
                .mapToInt(Asset::getValue)
                .sum();
    }
}
