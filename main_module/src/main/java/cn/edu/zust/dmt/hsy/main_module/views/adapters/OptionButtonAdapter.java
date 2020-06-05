package cn.edu.zust.dmt.hsy.main_module.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.edu.zust.dmt.hsy.main_module.R;

/**
 * @author MR.M
 * @version 1.0
 * @projectName TMS
 * @description $
 * @since 6/3/2020 20:04
 **/
public final class OptionButtonAdapter extends BaseAdapter {
    /**
     * @description store attributes input of adapter item view
     */
    public static final class OptionButtonAttributes {
        @ColorRes
        private final int mBackgroundColorRId;
        @DrawableRes
        private final int mIconDrawableRId;
        @StringRes
        private final int mTextStringRId;
        private final int mCornerRadius;

        public OptionButtonAttributes(@ColorRes int backgroundColorRId, @DrawableRes int iconDrawableRId,
                                      @StringRes int textStringRId, int cornerRadius) {
            mBackgroundColorRId = backgroundColorRId;
            mIconDrawableRId = iconDrawableRId;
            mTextStringRId = textStringRId;
            mCornerRadius = cornerRadius;
        }
    }

    private final List<OptionButtonAttributes> mAttributesList;
    private final LayoutInflater mLayoutInflater;

    public OptionButtonAdapter(@NonNull final List<OptionButtonAttributes> attributesList,
                               @NonNull final Context context) {
        mAttributesList = attributesList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mAttributesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAttributesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * @description refresh attributes of views existed or create views if not exist
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OptionButtonViewHolder currentViewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.mm_views_adapter_option_button, parent, false);
            currentViewHolder = new OptionButtonViewHolder(convertView);
            convertView.setTag(currentViewHolder);
        } else {
            currentViewHolder = (OptionButtonViewHolder) convertView.getTag();
        }
        currentViewHolder.mButtonCardView.setCardBackgroundColor(mLayoutInflater.getContext()
                .getResources().getColor(mAttributesList.get(position).mBackgroundColorRId));
        currentViewHolder.mButtonCardView.setRadius(mAttributesList.get(position).mCornerRadius);
        currentViewHolder.mIconImageView.setImageResource(mAttributesList.get(position).mIconDrawableRId);
        currentViewHolder.mOptionTextView.setText(mAttributesList.get(position).mTextStringRId);
        return convertView;
    }

    /**
     * @description extra views for {@link #getView(int, View, ViewGroup)} from layout
     */
    private static class OptionButtonViewHolder extends RecyclerView.ViewHolder {
        private final CardView mButtonCardView;
        private final ImageView mIconImageView;
        private final TextView mOptionTextView;

        public OptionButtonViewHolder(@NonNull final View itemView) {
            super(itemView);
            mButtonCardView = itemView.findViewById(R.id.mm_views_adapter_option_button_card_view);
            mIconImageView = itemView.findViewById(R.id.mm_views_adapter_option_button_image_view);
            mOptionTextView = itemView.findViewById(R.id.mm_views_adapter_option_button_text_view);
        }
    }
}
