package Bean;

public class HangBean {
    private SachBean sach;
    private Long soLuong;
    public HangBean() { }
    public HangBean(SachBean sach, Long soLuong) {
        super();
        this.sach = sach;
        this.soLuong = soLuong;
    }
    public SachBean getSach() {
        return sach;
    }
    public void setSach(SachBean sach) {
        this.sach = sach;
    }
    public Long getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }
}
