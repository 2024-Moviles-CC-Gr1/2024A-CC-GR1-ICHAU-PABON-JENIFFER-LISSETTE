package com.example.a2024accgr1jlip

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate

class BHospital(
    var id: Int,
    var nombre: String,
    var direccion: String,
    var capacidad: Int,
    var fechaFundacion: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nombre)
        parcel.writeString(direccion)
        parcel.writeInt(capacidad)
        parcel.writeString(fechaFundacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BHospital> {
        override fun createFromParcel(parcel: Parcel): BHospital {
            return BHospital(parcel)
        }

        override fun newArray(size: Int): Array<BHospital?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombre, $direccion, $capacidad, $fechaFundacion"
    }
}