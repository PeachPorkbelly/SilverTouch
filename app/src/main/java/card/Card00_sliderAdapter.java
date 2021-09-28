package card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.silvertouch.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class Card00_sliderAdapter extends RecyclerView.Adapter<Card00_sliderAdapter.SliderViewHolder> {

    private List<Card00_sliderItem> sliderItems;
    private ViewPager2 viewPager2;

    Card00_sliderAdapter(List<Card00_sliderItem> sliderItems, ViewPager2 viewPager2) {
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    // 뷰 홀더를 생성하고 뷰를 붙여주는 역활
    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.card_00_slide_item_container,
                        parent, false)
        );
    }

    // 뷰 홀더에 있는 onBind함수를 통해 리스트에 있는 position번째 값의 데이터를 넘겨줌
    // 리스트 끝에 올때 새로운 리스트를 추가해줌
    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position % 5));
        if (position == sliderItems.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    //데이터 개수 반환 *Integer.MAX_VALUE 사용하여 무한 페이지 처럼 보이게 함
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImage(Card00_sliderItem sliderItem) {
            imageView.setImageResource(sliderItem.getImage());
        }

    }

}
