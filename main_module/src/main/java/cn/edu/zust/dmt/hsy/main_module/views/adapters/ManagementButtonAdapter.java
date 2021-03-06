package cn.edu.zust.dmt.hsy.main_module.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class ManagementButtonAdapter extends BaseAdapter {
    /**
     * @description store attributes input of adapter item view
     */
    public static final class ManagementButtonAttributes {
        @ColorRes
        private final int mBackgroundColorRId;
        @DrawableRes
        private final int mIconDrawableRId;
        @StringRes
        private final int mTextStringRId;
        @NonNull
        private final View.OnClickListener mOnClickListener;

        public ManagementButtonAttributes(@ColorRes int backgroundColorRId, @DrawableRes int iconDrawableRId
                , @StringRes int textStringRId, @NonNull View.OnClickListener onClickListener) {
            mBackgroundColorRId = backgroundColorRId;
            mIconDrawableRId = iconDrawableRId;
            mTextStringRId = textStringRId;
            mOnClickListener = onClickListener;
        }
    }

    private final List<ManagementButtonAttributes> mAttributesList;
    private final LayoutInflater mLayoutInflater;

    public ManagementButtonAdapter(@NonNull final List<ManagementButtonAttributes> attributesList,
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
        return position;
    }

    /**
     * @description refresh attributes of views existed or create views if not exist
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ManagementButtonViewHolder currentViewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(
                    R.layout.mm_views_adapter_management_button, parent, false);
            currentViewHolder = new ManagementButtonViewHolder(convertView);
            convertView.setTag(currentViewHolder);
        } else {
            currentViewHolder = (ManagementButtonViewHolder) convertView.getTag();
        }
        final ManagementButtonAttributes attributes = mAttributesList.get(position);
        currentViewHolder.mButtonCardView.setCardBackgroundColor(mLayoutInflater.getContext()
                .getResources().getColor(attributes.mBackgroundColorRId));
        currentViewHolder.mIconImageView.setImageResource(attributes.mIconDrawableRId);
        currentViewHolder.mOptionTextView.setText(attributes.mTextStringRId);
        currentViewHolder.mButtonCardView.setOnClickListener(attributes.mOnClickListener);
        return convertView;
    }

    /**
     * @description extra views for {@link #getView(int, View, ViewGroup)} from layout
     */
    private static class ManagementButtonViewHolder extends RecyclerView.ViewHolder {
        private final CardView mButtonCardView;
        private final ImageView mIconImageView;
        private final TextView mOptionTextView;

        public ManagementButtonViewHolder(@NonNull final View itemView) {
            super(itemView);
            mButtonCardView = itemView.findViewById(R.id.mm_views_adapter_management_button_card_view);
            mIconImageView = itemView.findViewById(R.id.mm_views_adapter_management_button_image_view);
            mOptionTextView = itemView.findViewById(R.id.mm_views_adapter_management_button_text_view);
        }
    }
}
