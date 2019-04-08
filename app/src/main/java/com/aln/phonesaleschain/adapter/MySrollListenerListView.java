package com.aln.phonesaleschain.adapter;

import android.widget.AbsListView;
import android.widget.ListView;

public abstract class MySrollListenerListView implements ListView.OnScrollListener {
    int startingPage=1;
    int oldTotal = 0;
    int thresHold = 10;
    int currentPage = 1;
    boolean loading =false;

    public MySrollListenerListView(int page) {
        this.startingPage = page;
    }

    public MySrollListenerListView() {
    }

    public int getPage() {
        return currentPage;
    }

    public void setPage(int page) {
        this.currentPage = page;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (totalItemCount < oldTotal) {
//            Log.d("SCROOLL 1", loading + " last: "+lastVisible + " count: "+Itemcount + " old: " + oldTotal);
            this.currentPage = this.startingPage;
            oldTotal = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
            loadMore(currentPage,totalItemCount);
        }
// stop loading if Itemcount > oldtotal
        if (loading && totalItemCount > oldTotal) {
//            Log.d("SCROOLL 2", loading + " last: "+lastVisible + " count: "+Itemcount + " old: " + oldTotal);
            loading = false;
            oldTotal = totalItemCount;
        }
//load more if                           15
        if (!loading && (firstVisibleItem + thresHold+5) > totalItemCount) {
//            Log.d("SCROOLL 3", loading + " last: "+lastVisible + " count: "+Itemcount + " old: " + oldTotal);

            loadMore(currentPage, totalItemCount);
            currentPage++;
            loading = true;
        }
    }

    public abstract Boolean loadMore(int page, int totalItems);
}
