package presenter;


import module.ItemM;
import view.ItemView;

public class ItemP implements ItemPresenter{
    ItemView view;
    ItemM itemM;
    public ItemP(ItemView view) {
        this.view = view;
        itemM=new ItemM(view);
    }

    @Override
    public void getData() {
        itemM.initData();
    }

    @Override
    public void getWeChatData() {
        itemM.initWeChatData();
    }

    @Override
    public void getTagsData() {
        itemM.initTagsData();
    }

    @Override
    public void getSCData() {
        itemM.initSCData();
    }
}
