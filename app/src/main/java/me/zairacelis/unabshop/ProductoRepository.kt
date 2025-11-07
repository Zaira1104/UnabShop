package me.zairacelis.unabshop

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class ProductoRepository {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("productos")

    fun agregarProducto(producto: Producto, onResult: (Boolean) -> Unit) {
        collection.add(producto)
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }

    fun obtenerProductos(onResult: (List<Producto>) -> Unit) {
        collection.get()
            .addOnSuccessListener { result ->
                val productos = result.map { doc ->
                    doc.toObject<Producto>().copy(id = doc.id)
                }
                onResult(productos)
            }
            .addOnFailureListener { onResult(emptyList()) }
    }

    fun eliminarProducto(id: String, onResult: (Boolean) -> Unit) {
        collection.document(id)
            .delete()
            .addOnSuccessListener { onResult(true) }
            .addOnFailureListener { onResult(false) }
    }
}