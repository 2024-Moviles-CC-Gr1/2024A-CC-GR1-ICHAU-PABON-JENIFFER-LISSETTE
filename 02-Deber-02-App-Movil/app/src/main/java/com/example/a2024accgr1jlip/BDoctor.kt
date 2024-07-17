package com.example.a2024accgr1jlip

import android.os.Parcel
import android.os.Parcelable

class BDoctor (
    var cedula: String,
    var nombre: String,
    var especialidad: String,
    var edad: Int,
    var salario: Double,
    var idHospital: Int
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readInt()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cedula)
        parcel.writeString(nombre)
        parcel.writeString(especialidad)
        parcel.writeInt(edad)
        parcel.writeDouble(salario)
        parcel.writeInt(idHospital)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BDoctor> {
        override fun createFromParcel(parcel: Parcel): BDoctor {
            return BDoctor(parcel)
        }

        override fun newArray(size: Int): Array<BDoctor?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombre, $especialidad, $edad, $salario, $idHospital"
    }
}