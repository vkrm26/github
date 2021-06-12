package `in`.vikram.githubprs.custom

import `in`.vikram.githubprs.custom.Status.ERROR
import `in`.vikram.githubprs.custom.Status.LOADING
import `in`.vikram.githubprs.custom.Status.SUCCESS
import androidx.annotation.NonNull
import androidx.annotation.Nullable

class Resource<T>(@NonNull status: Status, @Nullable data: T, @Nullable message: String?) {

    @NonNull
    val status: Status = status

    @Nullable
    val message: String?

    @Nullable
    var data: T? = null

    companion object {

        fun <T> success(@Nullable data: T): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String?, @Nullable data: T): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }

    init {
        this.data = data
        this.message = message
    }

    

    override fun toString(): String {
        return "Resource { " +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}'
    }
    
}