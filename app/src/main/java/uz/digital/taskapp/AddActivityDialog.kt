package uz.digital.taskapp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import uz.digital.taskapp.databinding.DialogAddActivityBinding
import java.text.SimpleDateFormat
import java.util.*

class AddActivityDialog : DialogFragment() {

    private var _binding: DialogAddActivityBinding? = null
    private val binding get() = _binding!!

    private var onDissmisListener:DialogInterface.OnDismissListener? = null

    fun setOnDissmisLitener(onDismissListener: DialogInterface.OnDismissListener){
        this.onDissmisListener = onDissmisListener


    }


    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (onDissmisListener != null){
            onDissmisListener!!.onDismiss(dialog)
        }
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAddActivityBinding.inflate(inflater, container, false)


        binding.save.setOnClickListener {
            if (validate()) {

                val sdf = SimpleDateFormat("""dd/MM/yyyy""")

                val current = sdf.format(Date())

                val activity =
                    "${binding.checkboxTask.text.toString()}$current"
                PrefManager.saveActivity(requireContext(), activity)
                dismiss()

            }

        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    private fun validate(): Boolean {
        if (binding.checkboxTask.text.toString().isEmpty()) {
            binding.checkboxTask.error = "Enter the task"
            return false
        }
        if (binding.tvTime.text.toString().isEmpty()) {
            binding.tvTime.error = "Enter the time"
            return false
        }

        return true
    }

}