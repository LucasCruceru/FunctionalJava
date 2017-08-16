package ro.lucas.chapter4;

public class Asset {
    public enum AssetType{BOND, STOCK};
    private final AssetType type;
    private final int value;
    public Asset(final AssetType assetType, final int assetValue){
        type = assetType;
        value = assetValue;
    }
    public AssetType getType() {return type;}
    public int getValue() {return value;}
}
