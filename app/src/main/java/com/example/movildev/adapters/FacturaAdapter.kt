package com.example.movildev.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.movildev.R
import com.example.movildev.model.Factura
import com.example.movildev.repositories.FacturaRepository
import java.io.File
import java.io.FileOutputStream
import java.text.NumberFormat
import java.util.Locale

class FacturaAdapter(
    private var facturas: List<Factura>,
    private val onModificar: (Factura) -> Unit,
    private val onEliminar: (Factura) -> Unit
) : RecyclerView.Adapter<FacturaAdapter.FacturaViewHolder>() {
    private var facturasFiltradas: List<Factura> = facturas.toList()

    inner class FacturaViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val nombrePaciente: TextView = view.findViewById(R.id.nombrePacienteText)
        val valorCita: TextView = view.findViewById(R.id.valorCitaText)
        val tratamiento: TextView = view.findViewById(R.id.tratamiento)
        val fechaText: TextView = view.findViewById(R.id.fechaText)
        val horaText: TextView = view.findViewById(R.id.horaText)
        val btnModificar: Button = view.findViewById(R.id.btnModificar)
        val btnEliminar: Button = view.findViewById(R.id.btnEliminar)
        val btnDescargar: Button = view.findViewById(R.id.btnDescargar)
    }
    private fun generarPDF(context: Context, factura: Factura) {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(300, 600, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint()
        paint.textSize = 12f
        paint.color = Color.BLACK

        var y = 25

        canvas.drawText("Factura Electrónica", 80f, y.toFloat(), paint)
        y += 25
        canvas.drawText("Paciente: ${factura.paciente}", 10f, y.toFloat(), paint)
        y += 20
        canvas.drawText("Tratamiento: ${factura.tratamiento}", 10f, y.toFloat(), paint)
        y += 20
        canvas.drawText("Valor: $${"%,.0f".format(factura.valor)}", 10f, y.toFloat(), paint)
        y += 20
        canvas.drawText("Fecha: ${factura.fecha}", 10f, y.toFloat(), paint)
        y += 20
        canvas.drawText("Hora: ${factura.hora}", 10f, y.toFloat(), paint)

        pdfDocument.finishPage(page)

        // Guardar PDF
        val fileName = "Factura_${factura.id}.pdf"
        val file = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(context, "PDF generado en: ${file.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Error al generar PDF: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        pdfDocument.close()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacturaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.factura_tm, parent, false)
        return FacturaViewHolder(view)
    }



    override fun onBindViewHolder(holder: FacturaViewHolder, position: Int) {
        val factura = facturasFiltradas[position]
        val formatoPesos = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
        formatoPesos.maximumFractionDigits = 0

        holder.nombrePaciente.text = factura.paciente
        holder.valorCita.text = formatoPesos.format(factura.valor)
        holder.tratamiento.text = factura.tratamiento
        holder.fechaText.text = factura.fecha
        holder.horaText.text = factura.hora

        holder.btnModificar.setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(holder.itemView.context)
                .setTitle("Modificar factura")
                .setMessage("¿Desea modificar la factura?")
                .setPositiveButton("OK") { _, _ ->
                    onModificar(factura)
                }
                .show()
        }
        holder.btnEliminar.setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(holder.itemView.context)
                .setTitle("Eliminar factura")
                .setMessage("¿Desea eliminar la factura?")
                .setPositiveButton("OK") { _, _ ->
                    onEliminar(factura)
                }
                .show()
         }
        holder.btnDescargar.setOnClickListener {
            // Aquí puedes generar el PDF con los datos de `factura`
            generarPDF(context = holder.itemView.context, factura = factura)
        }

    }

    override fun getItemCount(): Int = facturasFiltradas.size

    fun updateData(newList: List<Factura>) {
        facturas = newList
        facturasFiltradas = newList
        notifyDataSetChanged()
    }

    fun filtrarPorNombre(query: String) {
        val filtro = query.trim()
        facturasFiltradas = if (filtro.isEmpty()) {
            facturas
        } else {
            facturas.filter {
                it.paciente.contains(filtro, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }



}

