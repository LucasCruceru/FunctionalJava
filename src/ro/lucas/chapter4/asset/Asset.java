package ro.lucas.chapter4.asset;

class Asset {
    public enum AssetType{BOND, STOCK}
    private final AssetType type;
    private final int value;
    Asset(final AssetType assetType, final int assetValue){
        type = assetType;
        value = assetValue;
    }
    AssetType getType() {return type;}
    int getValue() {return value;}
}
