package com.example.taxidriver.service

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.example.taxidriver.model.Driver


class DriverDiffCallback(private val oldList: List<Driver>, private val newList: List<Driver>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {

        return oldList[oldPosition].name == newList[newPosition].name && oldList[oldPosition].desc.equals(
            newList[newPosition].desc
        )
    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}