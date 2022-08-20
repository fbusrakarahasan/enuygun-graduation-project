package devices;

public enum DeviceFarm {
    ANDROID_NOUGAT("src/test/resources/capabilities/android-nougat.json");

    public  String path;
    DeviceFarm(String path) {
        this.path = path;
    }
}
