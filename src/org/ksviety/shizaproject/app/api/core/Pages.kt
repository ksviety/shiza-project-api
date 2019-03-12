package org.ksviety.shizaproject.app.api.core

const val DOMAIN: String = "http://www.shiza-project.com"

enum class Pages {

    STATUS_RECENT {
        override fun toString(): String {
            return "$DOMAIN/"
        }
    },
    STATUS_ONGOINGS {
        override fun toString(): String {
            return "$DOMAIN/status/ongoing"
        }
    },
    STATUS_NOVELTY {
        override fun toString(): String {
            return "$DOMAIN/status/novelty"
        }
    },
    STATUS_COMPLETED {
        override fun toString(): String {
            return "$DOMAIN/status/completed"
        }
    },
    STATUS_SUSPENDED {
        override fun toString(): String {
            return "$DOMAIN/status/suspended"
        }
    },
    STATUS_PLANNED {
        override fun toString(): String {
            return "$DOMAIN/status/planned"
        }
    },
    ABOUT {
        override fun toString(): String {
            return "$DOMAIN/about"
        }
    }

}